package org.agile4j.architecture.order.web;

import org.agile4j.architecture.order.service.IOrderService;
import org.agile4j.architecture.order.vo.OrderModel;
import org.agile4j.architecture.order.vo.OrderQueryModel;
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
@RequestMapping("/order")
public class OrderController {

	private static final Logger LOGGER = LogManager.getLogger(OrderController.class);
	
	@Autowired
	private IOrderService orderService;
	
	@RequestMapping(value="/toAdd", method=RequestMethod.GET)
	public String toAdd(){
		return "order/orderAdd";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(@ModelAttribute("om")OrderModel om) {
		this.orderService.create(om);
		return "success";
	}
	
	@RequestMapping(value="/toDelete/{uuid}", method=RequestMethod.GET)
	public String toDelete(@PathVariable("uuid")Integer uuid,Model model){
		OrderModel om = this.orderService.getByUuid(uuid);
		model.addAttribute("om", om);
		return "order/orderDelete";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(@RequestParam("uuid")Integer uuid) {
		this.orderService.delete(uuid);;
		return "success";
	}
	@RequestMapping(value="/toUpdate/{uuid}", method=RequestMethod.GET)
	public String toUpdate(@PathVariable("uuid")Integer uuid,Model model){
		OrderModel om = this.orderService.getByUuid(uuid);
		model.addAttribute("om", om);
		return "order/orderUpdate";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@ModelAttribute("om")OrderModel om) {
		this.orderService.update(om);
		return "success";
	}
	
	@RequestMapping(value="toList", method=RequestMethod.GET)
	public String toList(@ModelAttribute("wm")OrderWebModel wm, Model model){
		OrderQueryModel oqm = null ;
		if (Strings.isNullOrEmpty(wm.getQueryJsonStr())||Strings.isNullOrEmpty(wm.getQueryJsonStr().trim())) {
			oqm = new OrderQueryModel() ;
		} else {
			oqm = JsonUtil.str2Object(wm.getQueryJsonStr(), OrderQueryModel.class);
		}
		oqm.getPage().setNowPage(wm.getNowPage());
		if (wm.getRowCount() > 0) {
			oqm.getPage().setRowCount(wm.getRowCount());
		}
		Page<OrderModel> page = this.orderService.getByConditionPage(oqm);
		model.addAttribute("page", page);
		model.addAttribute("wm", wm);
		return "order/orderList";
	}
	
	@RequestMapping(value="/toQuery", method=RequestMethod.GET)
	public String toQuery(){
		return "order/orderQuery";
	}
}
