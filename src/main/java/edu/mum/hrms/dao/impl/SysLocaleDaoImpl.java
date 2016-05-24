package edu.mum.hrms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.mum.core.dao.HibernateEntityDao;
import edu.mum.core.exception.AppException;
import edu.mum.core.util.KeyValueBean;
import edu.mum.core.web.QueryReq;
import edu.mum.hrms.dao.SysLocaleDao;
import edu.mum.hrms.model.SysLocale;
import edu.mum.hrms.util.AppConstants;

@Repository("sysLocaleDao")
public class SysLocaleDaoImpl extends HibernateEntityDao<SysLocale> implements SysLocaleDao {

//	protected static Logger logger = LoggerFactory.getLogger(SysLocaleServiceImpl.class);

	@Override
	public List<KeyValueBean> listSysLocales() throws AppException {
		QueryReq req = new QueryReq();

		req.setSelect(" select new edu.mum.core.util.KeyValueBean(e.localeCode,e.localeName) from SysLocale e ");
		req.setWhere("e.status=?");
		req.setParams(new Integer[] { AppConstants.STATUS_VALID_1 });
		List<KeyValueBean> sysLocales = executeQuery(req);

		return sysLocales;
	}


}

