package org.agile4j.common.vo;

import java.io.Serializable;

import org.agile4j.common.utils.page.Page;

public class BaseModel implements Serializable {

	private Integer id;
	private Page page = new Page();
}
