package ehcache.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class EhcacheServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8588967401555549809L;

	private CacheManager cacheManager;

	@Override
	public void init() throws ServletException {
		System.out.println("init");
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		cacheManager = (CacheManager) ctx.getBean("cacheManager");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cache cache = cacheManager.getCache("ACTIVE_TASK_COUNT_CACHE");
		String key = "count";
		if (cache.get(key) == null) {
			cache.put(new Element(key, 1));
		} else {
			cache.put(new Element(key, Integer.valueOf((Integer) cache.get(key).getValue()) + 1));
		}
		resp.getWriter().println(cache.get(key));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

}
