package com.chinacache.loganalysis.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import com.chinacache.loganalysis.domain.SortJob;

public class HttpJobUtilsTest {

	@Test
	public void sortJob() {
		SortJob job1 = new SortJob();
		job1.setChannel_id("001");
		job1.setPriority(1);

		SortJob job2 = new SortJob();
		job2.setChannel_id("002");
		job2.setPriority(1);

		SortJob job3 = new SortJob();
		job3.setChannel_id("003");
		job3.setPriority(1);

		Set<SortJob> jobs = new TreeSet<SortJob>();
		jobs.add(job1);
		jobs.add(job2);
		jobs.add(job3);

		assertEquals(3, jobs.size());

		List<SortJob> listJobs = new ArrayList<SortJob>(jobs);
		assertEquals("003", listJobs.get(0).getChannel_id());
		assertEquals("002", listJobs.get(1).getChannel_id());
		assertEquals("002", listJobs.get(2).getChannel_id());

	}

}
