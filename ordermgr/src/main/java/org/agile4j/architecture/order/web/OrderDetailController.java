package org.agile4j.architecture.order.web;

import org.agile4j.architecture.order.service.IOrderDetailService;
import org.agile4j.architecture.order.vo.OrderDetailModel;
import org.agile4j.architecture.order.vo.OrderDetailQueryModel;
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
@RequestMapping("/orderDetail")
public class OrderDetailController {

	private static final Logger LOGGER = LogManager.getLogger(OrderDetailController.class);
	
	@Autowired
	private IOrderDetailService orderDetailService;
	
	
	@RequestMapping(value="/toAdd", method=RequestMethod.GET)
	public String toAdd(){
		return "orderDetail/orderDetailAdd";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(@ModelAttribute("om")OrderDetailModel om) {
		this.orderDetailService.create(om);
		return "success";
	}
	
	@RequestMapping(value="/toDelete/{uuid}", method=RequestMethod.GET)
	public String toDelete(@PathVariable("uuid")Integer uuid,Model model){
		OrderDetailModel odm = this.orderDetailService.getByUuid(uuid);
		model.addAttribute("odm", odm);
		return "orderDetail/orderDetailDelete";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(@RequestParam("uuid")Integer uuid) {
		this.orderDetailService.delete(uuid);;
		return "success";
	}
	@RequestMapping(value="/toUpdate/{uuid}", method=RequestMethod.GET)
	public String toUpdate(@PathVariable("uuid")Integer uuid,Model model){
		OrderDetailModel odm = this.orderDetailService.getByUuid(uuid);
		model.addAttribute("odm", odm);
		return "orderDetail/orderDetailUpdate";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@ModelAttribute("om")OrderDetailModel om) {
		this.orderDetailService.update(om);
		return "success";
	}
	
	@RequestMapping(value="/toList", method=RequestMethod.GET)
	public String toList(@ModelAttribute("wm")OrderDetailWebModel wm, Model model){
		OrderDetailQueryModel oqm = null ;
		if (Strings.isNullOrEmpty(wm.getQueryJsonStr())||Strings.isNullOrEmpty(wm.getQueryJsonStr().trim())) {
			oqm = new OrderDetailQueryModel() ;
		} else {
			oqm = JsonUtil.str2Object(wm.getQueryJsonStr(), OrderDetailQueryModel.class);
		}
		oqm.getPage().setNowPage(wm.getNowPage());
		if (wm.getRowCount() > 0) {
			oqm.getPage().setRowCount(wm.getRowCount());
		}
		Page<OrderDetailModel> page = this.orderDetailService.getByConditionPage(oqm);
		model.addAttribute("page", page);
		model.addAttribute("wm", wm);
		return "orderDetail/orderDetailList";
	}
	
	@RequestMapping(value="/toQuery", method=RequestMethod.GET)
	public String toQuery(){
		return "orderDetail/orderDetailQuery";
	}
}
