package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;

@Entity
public class ConfigKV extends BaseModel {

	@Enumerated(EnumType.STRING)
	public ConfigKey configKey;
	@Lob
	public String configValue;

	public enum ConfigKey {
		AutoReply, MENU
	}

	public static ConfigKV saveOrUpdateOne(ConfigKey key, String value) {
		ConfigKV kv = findByKey(key);
		if (null == kv) {
			kv = new ConfigKV();
			kv.configKey = key;
		}
		kv.configValue = value;
		return kv.save();
	}

	public static ConfigKV findByKey(ConfigKey key) {
		return find(getDefaultContitionSql("configKey=?"), key).first();
	}

	public static String getAutoReply() {
		ConfigKV autoReply = ConfigKV.findByKey(ConfigKey.AutoReply);
		return null == autoReply ? "已收到，我们会尽快回复您的。" : autoReply.configValue;
	}

	public static String getMenuSettings() {
		ConfigKV menuConfig = findByKey(ConfigKey.MENU);
		return null == menuConfig ? "" : menuConfig.configValue;
	}

}
