package org.agile4j.architecture.cartmgr.web;

import org.agile4j.architecture.cartmgr.service.ICartService;
import org.agile4j.architecture.cartmgr.vo.CartModel;
import org.agile4j.architecture.cartmgr.vo.CartQueryModel;
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
@RequestMapping("/cart")
public class CartController {

	private static final Logger LOGGER = LogManager.getLogger(CartController.class) ;
	
	@Autowired
	private ICartService cartService ;
	
	/**
	 * 跳转到新增页面
	 * @return
	 */
	@RequestMapping(value="/toAdd", method=RequestMethod.GET)
	public String toAdd() {
		return "cart/cartAdd" ;
	}
	
	/**
	 * 执行新增
	 * @param cm
	 * @return
	 */
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(@ModelAttribute("cm")CartModel cm) {
		cartService.create(cm);
		return "success";
	}
	
	/**
	 * 跳转到删除页面
	 * @param uuid
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/toDelete/{uuid}")
	public String toDelete(@PathVariable("uuid")Integer uuid,Model model) {
		CartModel cm = this.cartService.getByUuid(uuid) ;
		model.addAttribute("cm", cm); 
		return "cart/cartDelete" ;
	}
	
	/**
	 * 执行删除
	 * @param uuid
	 * @return
	 */
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(@RequestParam("uuid") Integer uuid) {
		this.cartService.delete(uuid);
		return "success";
	}
	
	/**
	 * 跳转到更新页面
	 * @param uuid
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/toUpdate/{uuid}", method=RequestMethod.POST)
	public String toUpdate(@PathVariable("uuid")Integer uuid, Model model){
		CartModel cm = this.cartService.getByUuid(uuid) ;
		model.addAttribute("cm", cm) ;
		return "cart/cartUpdate";
	}
	
	/**
	 * 执行更新
	 * @param cm
	 * @return
	 */
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@ModelAttribute("cm") CartModel cm) {
		this.cartService.update(cm);
		return "success" ;
	}
	
	/**
	 * 跳转到分页查询
	 * @param wm
	 * @param model
	 * @return
	 */
	@RequestMapping(value="toList", method=RequestMethod.GET)
	public String toList(@ModelAttribute("wm")CartWebModel wm,Model model){
		CartQueryModel cqm = null ;
		if (Strings.isNullOrEmpty(wm.getQueryJsonStr()) ||Strings.isNullOrEmpty(wm.getQueryJsonStr().trim())) {
			cqm = new CartQueryModel() ;
		} else {
			cqm = JsonUtil.str2Object(wm.getQueryJsonStr(), CartQueryModel.class) ;
		}
		cqm.getPage().setNowPage(wm.getNowPage()); // wm的nowPage是前台传过来的最新的
		if (wm.getRowCount() > 0) {
			cqm.getPage().setRowCount(wm.getRowCount());// 取得baseWebModel的默认行数
		}
		LOGGER.debug(wm);
		Page<CartModel> page = this.cartService.getByConditionPage(cqm) ;
		model.addAttribute("page", page) ;
		model.addAttribute("wm",wm);
		return "cart/cartList";
	}
	
	/**
	 * 跳转到查询页面
	 * @return
	 */
	@RequestMapping(value="toQuery", method=RequestMethod.GET)
	public String tuQuery() {
		return "cart/cartQuery";
	}
	
}
