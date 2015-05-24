package jobs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;


import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;

import play.Play;
import play.Play.ErrorPager;
import play.Play.PageFormat;
import play.db.jpa.JPA;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.templates.TemplateLoader;

@OnApplicationStart
public class StartUp extends Job {

	@Override
	public void doJob() throws Exception {
		super.doJob();
	}


	/**
	 * 系统启动时的管理员操作
	 * 
	 * @author
	 */
	private static void registerAdmin() {
		Session s = (Session) JPA.em().getDelegate();
		if (!s.getTransaction().isActive()) {
			s.getTransaction().begin();
		}

		s.getTransaction().commit();
	}

	
}
