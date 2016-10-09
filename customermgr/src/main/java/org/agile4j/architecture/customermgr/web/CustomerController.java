package org.agile4j.architecture.customermgr.web;

import java.util.Calendar;

import org.agile4j.architecture.customermgr.service.ICustomerService;
import org.agile4j.architecture.customermgr.vo.CustomerModel;
import org.agile4j.architecture.customermgr.vo.CustomerQueryModel;
import org.agile4j.common.utils.DateUtil;
import org.agile4j.common.utils.JsonUtil;
import org.agile4j.common.utils.page.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.common.base.Strings;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	private static final Logger LOGGER = LogManager.getLogger(CustomerController.class) ;
	
	@Autowired
	private ICustomerService customerService;

	/**
	 * 跳轉到新增頁面
	 * @return
	 */
	@RequestMapping(value = "toAdd", method = RequestMethod.GET)
	public String toAdd() {
		return "customer/customerAdd";
	}

	/**
	 * 執行新增
	 * @param cm
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(@ModelAttribute("cm") CustomerModel cm) {
		cm.setRegisterTime(DateUtil.date2String(Calendar.getInstance().getTime(), 1));
		customerService.create(cm);
		return "success";
	}

	/**
	 * 跳轉到更新頁面
	 * @param model
	 * @param customerId
	 * @return
	 */
	@RequestMapping(value = "toUpdate/{uuid}", method = RequestMethod.GET)
	public String toUpdate(Model model, @PathVariable("uuid") Integer uuid) {
		CustomerModel cm = customerService.getByUuid(uuid);
		model.addAttribute("cm", cm);
		LOGGER.debug(cm);
		return "customer/customerUpdate";
	}

	/**
	 * 執行更新
	 * @param cm
	 * @return
	 */
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(@ModelAttribute("cm") CustomerModel cm) {
		LOGGER.debug(cm);
		customerService.update(cm);
		return "success";
	}
	
	/**
	 * 跳轉刪除頁面
	 * @param model
	 * @param customerId
	 * @return
	 */
	@RequestMapping(value="toDelete/{uuid}", method=RequestMethod.GET)
	public String toDelete(Model model, @PathVariable("uuid") Integer uuid) {
		CustomerModel cm = customerService.getByUuid(uuid) ;
		LOGGER.debug(cm);
		model.addAttribute("cm", cm) ;
		return "customer/customerDelete" ;
	}
	
	/**
	 * 執行刪除
	 * @param id
	 * @return
	 */
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public String delete(@RequestParam("uuid") int uuid) {
		customerService.delete(uuid);
		return "success";
	}
	
	/**
	 * 執行分頁查詢
	 * @param wm
	 * @param model
	 * @return
	 */
	@RequestMapping(value="toList", method=RequestMethod.GET)
	public String toList(@ModelAttribute("wm")CustomerWebModel wm, Model model) {
		CustomerQueryModel cqm = null ;
		if (Strings.isNullOrEmpty(wm.getQueryJsonStr())||Strings.isNullOrEmpty(wm.getQueryJsonStr().trim())) {
			cqm = new CustomerQueryModel() ;
		} else {
			cqm = JsonUtil.str2Object(wm.getQueryJsonStr(), CustomerQueryModel.class) ;
		}
		cqm.getPage().setNowPage(wm.getNowPage());
		if (wm.getRowCount() > 0) {
			cqm.getPage().setRowCount(wm.getRowCount());
		}
		Page<CustomerModel> page = customerService.getByConditionPage(cqm) ;
		
		model.addAttribute("wm", wm) ;
		model.addAttribute("page", page) ;
		
		return "customer/customerList" ;
	}
	
	@RequestMapping(value="toQuery", method=RequestMethod.GET)
	public String toQuery(){
		return "customer/customerQuery" ;
	}
}
