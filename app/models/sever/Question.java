package models.sever;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;

import models.BaseModel;
import models.enums.QuestionType;

import org.apache.commons.lang.StringUtils;

@Entity
public class Question extends BaseModel {

	public String question;

	@Lob
	public String answer;

	@Enumerated(EnumType.STRING)
	public QuestionType questionType;

	public static Question createQuestion() {
		Question question = new Question();
		question.questionType = QuestionType.others;
		return question.save();
	}

	public void updateQuestion(String question, String questionType,
			String answer) {
		this.question = question;
		this.answer = answer;
		this.questionType = QuestionType.convert2Enum(questionType);
		this.save();

	}

	public void removeQuestion() {
		isDeleted = true;
		this.save();
	}

	public static Question findOneById(long qaId) {
		Question qa = findById(qaId);
		return null != qa ? qa : null;
	}

	public static List<Question> fetchQuestions(int page, int pageSize) {
		return find(
				"select q from Question q where q.isDeleted = false order by createTime desc")
				.fetch(page, pageSize);
	}

	public static List<Question> fetchByQuestion(String question, int page,
			int pageSize) {
		return find(
				getDefaultContitionSql(" question like ? order by createTime desc"),
				"%" + question + "%").fetch(page, pageSize);
	}

	public static List<Question> fetchByType(QuestionType questionType,
			int page, int pageSize) {
		return find(
				getDefaultContitionSql(" questionType = ? order by createTime desc"),
				questionType).fetch(page, pageSize);
	}

	public static List<Question> fetchByTypes(String question,
			QuestionType questionType, int page, int pageSize) {
		List<Object> paraList = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(
				"select q from Question q where q.isDeleted = false");
		if (StringUtils.isNotBlank(question)) {
			hql.append(" and q.question like ?");
			paraList.add("%" + question + "%");
		}
		if (null != questionType) {
			hql.append(" and q.questionType = ?");
			paraList.add(questionType);
		}
		return find(hql.toString(), paraList.toArray()).fetch(page, pageSize);
	}

	public static int countQuestion(String question, QuestionType questionType,
			int page, int pageSize) {
		List<Object> paraList = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(
				"select q from Question q where q.isDeleted = false");
		if (StringUtils.isNotBlank(question)) {
			hql.append(" and q.question like ?");
			paraList.add("%" + question + "%");
		}
		if (null != questionType) {
			hql.append(" and q.questionType = ?");
			paraList.add(questionType);
		}
		return find(hql.toString(), paraList.toArray()).fetch().size();
	}
}
