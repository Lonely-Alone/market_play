package jobs;

import java.util.List;

import org.hibernate.Session;

import models.order.OrderSum;
import play.db.jpa.JPA;
import play.jobs.Every;
import play.jobs.Job;
import play.jobs.On;

@Every("15mn")
public class CancelOrder extends Job {

	@Override
	public void doJob() throws Exception {
		OrderSum.cancelOrders();

	}

}
