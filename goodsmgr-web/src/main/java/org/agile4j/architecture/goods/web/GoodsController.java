package org.agile4j.architecture.goods.web;

import org.agile4j.architecture.goods.service.IGoodsService;
import org.agile4j.architecture.goods.vo.GoodsModel;
import org.agile4j.architecture.goods.vo.GoodsQueryModel;
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
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	private IGoodsService goodsService ;
	
	/**
	 * 跳转到新增页面
	 * @return
	 */
	@RequestMapping(value="/toAdd", method=RequestMethod.GET)
	public String toAdd(){
		return "goods/goodsAdd" ;
	}
	
	/**
	 * 执行新增
	 * @param gm
	 * @return
	 */
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public String list(@ModelAttribute("gm")GoodsModel gm){
		this.goodsService.create(gm);
		return "success";
	}

	/**
	 * 跳转到删除页面
	 * @param uuid
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/toDelete/{uuid}", method=RequestMethod.GET)
	public String toDelete(@PathVariable("uuid")Integer uuid, Model model){
		GoodsModel gm = this.goodsService.getByUuid(uuid) ;
		model.addAttribute("gm", gm) ;
		return "goods/goodsDelete";
	}
	
	/**
	 * 执行删除
	 * @param uuid
	 * @return
	 */
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(@RequestParam("uuid") Integer uuid) {
		this.goodsService.delete(uuid);
		return "success";
	}
	
	/**
	 * 跳转到更新页面
	 * @param uuid
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/toUpdate/{uuid}", method=RequestMethod.GET)
	public String toUpdate(@PathVariable("uuid")Integer uuid,Model model){
		GoodsModel gm = this.goodsService.getByUuid(uuid) ;
		model.addAttribute("gm", gm) ;
		return "goods/goodsUpdate";
	}
	
	/**
	 * 执行更新
	 * @param gm
	 * @return
	 */
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@ModelAttribute("gm")GoodsModel gm){
		this.goodsService.update(gm);
		return "success";
	}
	
	/**
	 * 跳转到分页查询页面
	 * @param wm
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/toList", method=RequestMethod.GET)
	public String toList(@ModelAttribute("wm")GoodsWebModel wm, Model model) {
		GoodsQueryModel gqm = null;
		if (Strings.isNullOrEmpty(wm.getQueryJsonStr())||Strings.isNullOrEmpty(wm.getQueryJsonStr().trim())) {
			gqm = new GoodsQueryModel() ;
		} else {
			gqm = JsonUtil.str2Object(wm.getQueryJsonStr(), GoodsQueryModel.class) ;
		}
		gqm.getPage().setNowPage(wm.getNowPage());// nowPage是前台分页插件传过来;或初始化时的1页
		if (wm.getRowCount() > 0) {
			gqm.getPage().setRowCount(wm.getRowCount());// 取得baseWebModel的默认行数
		}
		Page<GoodsModel> page = this.goodsService.getByConditionPage(gqm);
		model.addAttribute("page", page);
		model.addAttribute("wm", wm);
		return "goods/goodsList";
	}
	
	/**
	 * 跳转到查询页面
	 * @return
	 */
	@RequestMapping(value="toQuery", method=RequestMethod.GET)
	public String toQuery(){
		return "goods/goodsQuery" ;
	}
}
