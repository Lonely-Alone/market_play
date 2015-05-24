package models;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import jpaListeners.BaseModelListener;

import org.apache.commons.lang.StringUtils;

import play.db.jpa.Model;

/**
 * 全站使用的基本数据
 * 
 * @author mayan
 * 
 */
@MappedSuperclass
@EntityListeners(BaseModelListener.class)
public class BaseModel extends Model {
	/**
	 * 标记删除
	 */
	public boolean isDeleted = false;
	@Version
	public long version;
	@Temporal(TemporalType.TIMESTAMP)
	public Date createTime = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	public Date lastModifyTime = new Date();

	public static String defaultCondition() {
		return "isDeleted=false";
	}

	private static final String AND = " and ";
	private static final String FROM = " from ";
	private static final String WHERE = " where ";
	private static final String FROM_WHERE_PATTERN = "from\\s([\\S].*?)\\swhere\\s";

	/**
	 * 可以在sql中加入默认条件，如：<br>
	 * 在BaseModel中的默认条件是：isDeleted=false<br>
	 * 此方法目前存在缺陷，不能支持不含where表达式的子查询，例如:<br>
	 * select a from b where c in (select d from f)<br>
	 * 
	 * @param originSql
	 * @return
	 */
	public static String getDefaultContitionSql(String originStr) {
		String originSql = originStr;
		if (StringUtils.containsIgnoreCase(originSql, FROM)) {
			if (StringUtils.containsIgnoreCase(originSql, WHERE)) {
				Pattern pattern = Pattern.compile(FROM_WHERE_PATTERN,
						Pattern.CASE_INSENSITIVE);
				Matcher matcher = pattern.matcher(originSql);
				while (matcher.find()) {
					String tableName = matcher.group(1);
					String newSqlString = (tableName.contains(" ") ? tableName
							.substring(tableName.lastIndexOf(' ') + 1) + '.'
							: "")
							+ defaultCondition() + AND;
					String originString = matcher.group();
					originSql = originSql.replace(originString, originString
							+ newSqlString);
				}
			} else {
				originSql = originSql + WHERE + defaultCondition();
			}
		} else {
			originSql = defaultCondition() + AND + originSql;
		}
		return originSql;
	}

}