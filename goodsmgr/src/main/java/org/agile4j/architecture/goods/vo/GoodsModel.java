package org.agile4j.architecture.goods.vo;

import org.agile4j.common.vo.BaseModel;

public class GoodsModel extends BaseModel {

	private String name;
	private String imgPath ;
	private String description ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "GoodsModel [uuid=" + getUuid() + ", name=" + name + ", imgPath=" + imgPath + ", description="
				+ description + "]";
	}
	
}
