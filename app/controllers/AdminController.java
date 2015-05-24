package controllers;

import japidviews._javatags.CommonUtils;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import models.enums.OrderStatus;
import models.enums.QuestionType;
import models.goods.Attachment;
import models.goods.Good;
import models.goods.Good.GoodPlace;
import models.goods.GoodType;
import models.order.Location;
import models.order.OrderItem;
import models.order.OrderSum;
import models.order.PayNotify;
import models.person.Admin;
import models.person.Member;
import models.person.Person;
import models.sever.Consult;
import models.sever.Question;
import models.vo.Result;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

import play.data.binding.As;
import utils.PictureUtil;
import utils.PictureUtil.Effect;
import cn.bran.play.JapidPlayAdapter;

/**
 * 后台管理
 *
 * @author
 */
public class AdminController extends BaseController {

	public static final int PAGESIZE = 10;

	/**** 左侧一级链接 ****/
	public static void personCenter() {
		renderJapid();
	}

	/**
	 * 发布商品
	 */
	public static void publishGood() {
		editGood(0l);
	}

	/**
	 * 商品管理
	 */
	public static void manageGood(String name, Boolean inSold, Integer page) {
		if (page == null) {
			page = 1;
		}
		List<Good> goods = Good.fetchGoods(name, inSold, PAGESIZE, page);
		int goodCount = Good.countGoods(name, inSold);
		int pageCount = ((goodCount - 1) / PAGESIZE + 1);

		renderJapid(name, inSold, goods, goodCount, pageCount, page);
	}

	/**
	 * 订单管理
	 */
	public static void manageOrderSum(OrderStatus orderFilter, String goodName,
			String orderSerial,
			@As(format = "yyyy-MM-dd HH:mm:ss") Date dateFrom,
			@As(format = "yyyy-MM-dd HH:mm:ss") Date dateTo, int page) {
		page = 0 == page ? 1 : page;
		goodName = StringUtils.defaultIfBlank(goodName, "");
		orderSerial = StringUtils.defaultIfBlank(orderSerial, "");
		orderFilter = null == orderFilter ? OrderStatus.OTHER : orderFilter;
		if (null != dateTo) {
			dateTo = DateUtils.addDays(dateTo, 1);
		}

		List<OrderSum> sums = OrderSum.fetchOrderSums(orderFilter, orderSerial,
				goodName, dateFrom, dateTo, PAGESIZE, page);
		int sumCount = OrderSum.countOrderSums(orderFilter, orderSerial,
				goodName, dateFrom, dateTo);
		int pageCount = (sumCount - 1) / PAGESIZE + 1;

		Map<Long, List<OrderItem>> map = OrderItem.fetchBySums(sums);
		if (null != dateTo) {
			dateTo = DateUtils.addDays(dateTo, -1);
		}

		renderJapid(sums, map, orderFilter, goodName, orderSerial, dateFrom,
				dateTo, sumCount, pageCount, page);
	}

	/**
	 * 账单流水
	 */
	public static void manageBill(
			@As(format = "yyyy-MM-dd HH:mm:ss") Date dateFrom,
			@As(format = "yyyy-MM-dd HH:mm:ss") Date dateTo, int page) {
		page = 0 == page ? 1 : page;
		if (null != dateTo) {
			dateTo = DateUtils.addDays(dateTo, 1);
		}
		List<PayNotify> bills = PayNotify.fetchPayNotifies(dateFrom, dateTo,
				page, PAGESIZE);
		int payCount = PayNotify.countAll();
		int pageCount = (payCount - 1) / PAGESIZE + 1;

		if (null != dateTo) {
			dateTo = DateUtils.addDays(dateTo, -1);
		}
		renderJapid(bills, dateFrom, dateTo, page, payCount, pageCount);
	}

	/**
	 * 会员管理
	 */
	public static void manageVIP(String nickName, int page) {
		nickName = StringUtils.defaultIfBlank(nickName, "");
		page = 0 == page ? 1 : page;
		List<Member> members = Member.fetchMembers(nickName, page, PAGESIZE);
		int memberCount = Member.fetchMembers("", 1, Integer.MAX_VALUE).size();
		int pageCount = (memberCount - 1) / PAGESIZE + 1;

		renderJapid(members, nickName, page, pageCount, memberCount);
	}

	// 取货验证
	public static void deliverConfirm() {
		renderJapid();
	}

	public static void jsonDeliver(String pass) {
		OrderSum orderSum = OrderSum.findOneByPassword(pass);
		if (orderSum == null) {
			renderJSON(new Result(false));
		}
		List<OrderItem> itemList = OrderItem.fetchBySum(orderSum);
		renderJapid(orderSum, itemList);
	}

	// 求购管理
	public static void manageConsult(int page) {
		page = 0 == page ? 1 : page;
		List<Consult> consultList = Consult.fecthConsults(page, PAGESIZE);
		int consultCount = Consult.countConsult(page, Integer.MAX_VALUE);
		int pageCount = consultCount / PAGESIZE + 1;
		renderJapid(consultList, consultCount, pageCount, page);
	}

	public static void removeConsults(List<Long> consultIds) {
		String failIds = "";
		for (Long id : consultIds) {
			Consult consult = Consult.findByConsultId(id);
			if (null == consult) {
				failIds += id + " ";
			} else {
				consult.removeConsult();
			}
		}
		if (failIds.length() > 0) {
			renderJSON(new Result(false, failIds));
		} else {
			renderJSON(new Result(true));
		}
	}

	// 发布问答
	public static void publishQuestion() {
		editQuestion(0l);
	}

	public static void editQuestion(long qaId) {
		Question qa = Question.findOneById(qaId);
		renderJapid(qa);
	}

	public static void saveQuestion(long questionId, String question,
			String questionType, String answer) {
		Question ques = Question.findOneById(questionId);
		if (null == ques) {
			ques = Question.createQuestion();
		}
		ques.updateQuestion(question, questionType, answer);
		renderJSON(new Result(true, "保存成功，请在问答管理中查看！"));
	}

	public static void manageQuestion(String question,
			QuestionType questionType, int page) {
		page = 0 == page ? 1 : page;
		List<Question> questionList = Question.fetchByTypes(question,
				questionType, page, PAGESIZE);
		int questionCount = Question.countQuestion(question, questionType,
				page, Integer.MAX_VALUE);
		int pageCount = (questionCount - 1) / PAGESIZE;
		renderJapid(questionList, questionCount, pageCount, page, questionType,
				question);
	}

	public static void filterQuestions(String question, String questionType) {
		String string = JapidPlayAdapter.lookup(
				"AdminController.manageQuestion", question,
				QuestionType.convert2Enum(questionType), 1);
		renderJSON(new Result(true, "", StringUtils.replace(string, "amp;", "")));
	}

	public static void removeQuestions(List<Long> questionIds) {
		String failIds = "";
		for (Long id : questionIds) {
			Question ques = Question.findOneById(id);
			if (null == ques) {
				failIds += id + " ";
			} else {
				ques.removeQuestion();
			}
		}
		if (failIds.length() > 0) {
			renderJSON(new Result(false, failIds));
		} else {
			renderJSON(new Result(true));
		}
	}

	/*************************** 中间跳转页面 **********************************/

	/**
	 * 发布/编辑商品
	 */
	public static void editGood(long goodId) {
		renderJapid(Good.findById(goodId),
				Attachment.fetchPictuesByGood(goodId),
				GoodType.fetchGoodTypes());
	}

	public static void goodPreview(long goodId) {
		renderJapid(Good.findById(goodId),
				Attachment.fetchPictuesByGood(goodId));
	}

	public static void goodSavePreview(String name, String chief, String descr,
			String imageURL, int showPrice, int realPrice, int leftCount,
			List<String> picUrls, long goodTypeId, String goodPlace) {
		GoodType type = GoodType.findByTypeId(goodTypeId);
		renderJapid(name, chief, descr, imageURL, showPrice, realPrice,
				leftCount, picUrls, type, goodPlace);
	}

	public static void orderSumDetail(long orderSumId) {
		OrderSum sum = OrderSum.findOneById(orderSumId);
		renderJapid(sum, OrderItem.fetchBySum(sum));
	}

	/**
	 * 流水管理用
	 */
	public static void sumDetail(String orderSerial) {
		OrderSum sum = OrderSum.findOneByOrderSerial(orderSerial);
		orderSumDetail(sum.id);
	}

	/************************* JSON page *************************/

	public static void jsonGoodPreview(long goodId) {
		renderJapid(goodId);
	}

	public static void jsonGoodSavePreview(String name, String chief,
			String descr, String imageURL, int showPrice, int realPrice,
			int leftCount, @As(",") List<String> picUrls, long goodTypeId,
			String goodPlace) {
		renderJapid(name, chief, descr, imageURL, showPrice, realPrice,
				leftCount, picUrls, goodTypeId, goodPlace);
	}

	public static void jsonConsultPreview(long consultId) {
		renderJapid(consultId);
	}

	/************************* AJAX *************************/
	public static void savePassword(String oldPwd, String newPwd) {
		Person currPerson = CommonUtils.getCurrentPerson();
		boolean isPwdCorrect = currPerson.validatePwd(oldPwd);
		if (isPwdCorrect) {
			currPerson.updatePassword(newPwd);
			renderJSON(new Result(true));
		} else {
			renderJSON(new Result(false));
		}
	}

	public static void resetPassword(long shopId) {
		Admin shop = (Admin) Admin.findOneById(shopId);
		shop.resetPassword();
		renderJSON(new Result(true));
	}

	public static void upload(File file, String target, int width, int height,
			Effect effect) {
		String origin = PictureUtil.uploadFile(file);
		String preview = PictureUtil.getPictureFromPicServer(width, height,
				effect, origin);
		renderHtml("<script type=\"text/javascript\">parent.iFrameCallBack('"
				+ target + "|" + origin + "|" + preview + "|"
				+ (file.length() / 1024 <= 5000) + "');</script>");
	}

	public static void uploadAvatar(File file) {
		String origin = PictureUtil.uploadFile(file);
		String preview = PictureUtil.getPictureFromPicServer(100, 100,
				Effect.CUT, origin);
		renderHtml("<script type=\"text/javascript\">parent.iFrameCallBack('"
				+ origin + "|" + preview + "');</script>");
	}

	public static void saveGood(long goodId, String name, String chief,
			int showPrice, int realPrice, int leftCount, int limitCount,
			@As(",") List<String> picUrls, String descr, boolean isPublished,
			String imageURL, String previewURL, long goodTypeId,
			GoodPlace goodPlace) {
		Good good = Good.findById(goodId);
		if (null == good) {
			good = Good.createOne();
		}
		good.updateAttributes(name, chief, showPrice, realPrice, leftCount,
				limitCount, descr, isPublished, imageURL, previewURL, picUrls,
				goodTypeId, goodPlace);

		renderJSON(new Result(true, "保存成功，请在商品管理中查看！"));
	}

	public static void removeGoods(List<Long> goodIds) {
		String failIds = "";
		for (Long id : goodIds) {
			Good good = Good.findById(id);
			if (null == good) {
				failIds += id + " ";
			} else {
				good.removeOne();
			}
		}
		if (failIds.length() > 0) {
			renderJSON(new Result(false, failIds));
		} else {
			renderJSON(new Result(true));
		}
	}

	public static void filterGoods(String name, Boolean inSold) {
		String string = JapidPlayAdapter.lookup("AdminController.manageGood",
				name, inSold);
		renderJSON(new Result(true, "", StringUtils.replace(string, "amp;", "")));
	}

	public static void filterOrders(OrderStatus orderFilter, String goodName,
			String orderSerial,
			@As(format = "yyyy-MM-dd HH:mm:ss") Date dateFrom,
			@As(format = "yyyy-MM-dd HH:mm:ss") Date dateTo) {
		renderJSON(new Result(true, "", StringUtils.replace(JapidPlayAdapter
				.lookup("AdminController.manageOrderSum", orderFilter,
						goodName, orderSerial, dateFrom, dateTo), "amp;", "")));
	}

	public static void filterBills(long shopId,
			@As(format = "yyyy-MM-dd HH:mm:ss") Date dateFrom,
			@As(format = "yyyy-MM-dd HH:mm:ss") Date dateTo) {
		renderJSON(new Result(true, "", StringUtils.replace(
				JapidPlayAdapter.lookup("AdminController.manageBill", shopId,
						dateFrom, dateTo), "amp;", "")));
	}

	public static void filterVIPs(String nickName) {
		renderJSON(new Result(true, "", StringUtils.replace(
				JapidPlayAdapter.lookup("AdminController.manageVIP", nickName),
				"amp;", "")));
	}

	public static void cancelOrderSum(long orderSumId) {
		OrderSum sum = OrderSum.findOneById(orderSumId);
		if (sum.getStatus() == OrderStatus.NOT_PAID
				|| sum.getStatus() == OrderStatus.NOT_DELIVERED) {
			sum.cancel();
			renderJSON(new Result(true));
		} else {
			renderJSON(new Result(false, "订单已发货，不能取消"));
		}
	}

	/**
	 * 商品类型管理
	 * 
	 * @param name
	 * @param id
	 * @param page
	 */
	public static void manageGoodType(String name, long id, Integer page) {
		if (page == null) {
			page = 1;
		}
		List<GoodType> typeList = GoodType.fetchTypes(name, page, PAGESIZE);
		int typeCount = GoodType.typeCount(name, page, Integer.MAX_VALUE);
		int pageCount = typeCount / PAGESIZE + 1;
		renderJapid(typeList, typeCount, pageCount, page);
	}

	/**
	 * 添加商品类型
	 * 
	 * @param name
	 */
	public static void addGoodType(String name) {
		GoodType.createOne(name);
		renderJSON(new Result(
				JapidPlayAdapter.lookup("AdminController.manageGoodType")));
	}

	/**
	 * 筛选商品类型
	 * 
	 * @param name
	 */
	public static void filterGoodType(String name) {
		renderJSON(new Result(JapidPlayAdapter.lookup(
				"AdminController.manageGoodType", name)));
	}

	/**
	 * @param typeIds
	 */
	public static void removeGoodTypes(List<Long> typeIds) {
		String failIds = "";
		for (Long id : typeIds) {
			GoodType type = GoodType.findByTypeId(id);
			if (null == type) {
				failIds += id + " ";
			} else {
				type.deleteOne();
			}
		}
		if (failIds.length() > 0) {
			renderJSON(new Result(false, failIds));
		} else {
			renderJSON(new Result(true));
		}
	}

	/**
	 * 商品自取地点管理
	 * 
	 * @param address
	 * @param page
	 */
	public static void manageLocation(String address, Integer page) {
		if (page == null) {
			page = 1;
		}
		List<Location> typeList = Location.fetchLocations(address, page,
				PAGESIZE);
		int locationCount = Location.locationCount(address, page,
				Integer.MAX_VALUE);
		int pageCount = locationCount / PAGESIZE + 1;
		renderJapid(typeList, locationCount, pageCount, page);
	}

	public static void addLocation(String address) {
		Location.createOne(address);
		renderJSON(new Result(
				JapidPlayAdapter.lookup("AdminController.manageLocation")));
	}

	public static void removeLocations(List<Long> locationIds) {
		String failIds = "";
		for (Long id : locationIds) {
			Location location = Location.findById(id);
			if (null == location) {
				failIds += id + " ";
			} else {
				location.deleteOne();
			}
		}
		if (failIds.length() > 0) {
			renderJSON(new Result(false, failIds));
		} else {
			renderJSON(new Result(true));
		}
	}

	public static void filterLocation(String address) {
		renderJSON(new Result(JapidPlayAdapter.lookup(
				"AdminController.manageLocation", address)));
	}
}
