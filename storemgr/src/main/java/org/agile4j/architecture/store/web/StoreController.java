package org.agile4j.architecture.store.web;

import org.agile4j.architecture.store.service.IStoreService;
import org.agile4j.architecture.store.vo.StoreModel;
import org.agile4j.architecture.store.vo.StoreQueryModel;
import org.agile4j.common.utils.JsonUtil;
import org.agile4j.common.utils.page.Page;
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
@RequestMapping("/store")
public class StoreController {

	@Autowired
	private IStoreService storeService ;
	
	/**
	 * 跳转到新增页面
	 * @return
	 */
	@RequestMapping(value="/toAdd", method=RequestMethod.GET)
	public String toAdd(){
		return "store/storeAdd";
	}
	
	/**
	 * 执行新增
	 * @param sm
	 * @return
	 */
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(@ModelAttribute("sm")StoreModel sm){
		this.storeService.create(sm);
		return "success";
	}
	
	/**
	 * 跳转到删除页面
	 * @param uuid
	 * @return
	 */
	@RequestMapping(value="/toDelete/{uuid}", method=RequestMethod.GET)
	public String toDelete(@PathVariable("uuid")Integer uuid, Model model) {
		StoreModel sm = this.storeService.getByUuid(uuid);
		model.addAttribute("sm", sm);
		return "store/storeDelete" ;
	}
	
	/**
	 * 执行删除
	 * @param uuid
	 * @return
	 */
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(@RequestParam("uuid")Integer uuid) {
		this.storeService.delete(uuid);
		return "success";
	}
	
	/**
	 * 跳转更新页面
	 * @param uuid
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/toUpdate/{uuid}", method=RequestMethod.GET)
	public String toUpdate(@PathVariable("uuid")Integer uuid, Model model){
		StoreModel sm = this.storeService.getByUuid(uuid);
		model.addAttribute("sm", sm);
		return "store/storeUpdate";
	}
	
	/**
	 * 执行修改操作
	 * @param sm
	 * @return
	 */
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@ModelAttribute("sm")StoreModel sm) {
		this.storeService.update(sm);
		return "success";
	}
	
	/**
	 * 跳转到分页查询
	 * @param wm
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/toList", method=RequestMethod.GET)
	public String toList(@ModelAttribute("wm")StoreWebModel wm,Model model) {
		StoreQueryModel sqm = null ;
		if (Strings.isNullOrEmpty(wm.getQueryJsonStr())||Strings.isNullOrEmpty(wm.getQueryJsonStr().trim())) {
			sqm = new StoreQueryModel() ;
		} else {
			sqm = JsonUtil.str2Object(wm.getQueryJsonStr(), StoreQueryModel.class);
		}
		sqm.getPage().setNowPage(wm.getNowPage());
		if (wm.getRowCount() > 0) {
			sqm.getPage().setRowCount(wm.getRowCount());
		}
		Page<StoreModel> page= this.storeService.getByConditionPage(sqm);
		model.addAttribute("page", page);
		model.addAttribute("wm", wm);
		return "store/storeList";
	}
	
	@RequestMapping(value="/toQuery", method=RequestMethod.GET)
	public String toQuery(){
		return "store/storeQuery" ;
	}
}
