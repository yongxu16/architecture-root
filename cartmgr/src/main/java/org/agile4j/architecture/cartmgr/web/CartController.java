package org.agile4j.architecture.cartmgr.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cart")
public class CartController {

	private static final Logger LOGGER = LogManager.getLogger(CartController.class) ;
	
	@RequestMapping(value="/toAdd", method=RequestMethod.GET)
	public String toAdd() {
		return "cart/cartAdd" ;
	}
	
	
}
