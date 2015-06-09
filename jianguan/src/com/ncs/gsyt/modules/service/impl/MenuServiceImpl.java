package com.ncs.gsyt.modules.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;

import org.springframework.stereotype.Service;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.core.base.search.Sort;
import com.ncs.gsyt.modules.dao.MenuDao;
import com.ncs.gsyt.modules.model.Function;
import com.ncs.gsyt.modules.model.Menu;
import com.ncs.gsyt.modules.model.Role;
import com.ncs.gsyt.modules.model.ZTreeObject;
import com.ncs.gsyt.modules.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
	@Resource
	private MenuDao menuDao;

	public List<Menu> findMenuTreeByPId() {
		Search search = new Search(Menu.class);
		Sort sort = new Sort();
		sort.setProperty("nodeCode");
		sort.setDesc(false);
		search.addSorts(sort);
		return menuDao.search(search);
	}

	@Override
	public Menu findById(String nodeCode) {
		Search search = new Search();
		search.addFilterEqual("nodeCode", nodeCode);
		return menuDao.searchUnique(search);
	}

	public JSON findMenuTreeJSON(String contexPath) {
		List<Menu> lstPriv = this.findMenuTreeByPId();

		List<ZTreeObject> nList = new ArrayList<ZTreeObject>();
		ZTreeObject nMenu = null;
		for (Menu menu : lstPriv) {
			nMenu = new ZTreeObject();
			nMenu.setId(menu.getNodeCode());
			nMenu.setName(menu.getNodeName());
			nMenu.setPid(menu.getParentNode());
			nMenu.setUrl(contexPath + "/admin/menu!initUpdate.do?nodeCode="
					+ menu.getNodeCode());
			nList.add(nMenu);
		}
		JSON json = JSONSerializer.toJSON(nList);
		return json;
	}

	public JSON findMenuTreeAhor(String contexPath, Role role) {
		List<Menu> lstPriv = this.findMenuTreeByPId();

		List<ZTreeObject> nList = new ArrayList<ZTreeObject>();
		ZTreeObject nMenu = null;

		for (Menu menu : lstPriv) {
			nMenu = new ZTreeObject();
			for (Menu mm : role.getMenus()) {
				if (mm.getNodeCode().equals(menu.getNodeCode())) {
					nMenu.setChecked(true);
				}
			}
			nMenu.setId(menu.getNodeCode());
			nMenu.setName(menu.getNodeName());
			nMenu.setPid(menu.getParentNode());
			nMenu.setOpen(true);
			if ("-1".equals(menu.getParentNode()))
				nMenu.setNocheck(true);
			nList.add(nMenu);
			for (Function funct : menu.getFuncs()) {
				nMenu = new ZTreeObject();
				nMenu.setId("F_" + funct.getId());
				nMenu.setName(funct.getFunctionName());
				nMenu.setPid(menu.getNodeCode());
				for (Function ff : role.getFuncs()) {
					//if (funct.getFunctionCode().equals(ff.getFunctionCode())) {
					if (funct.getId()==ff.getId()) {
						nMenu.setChecked(true);
					}
				}
				nList.add(nMenu);

			}
		}
		JSON json = JSONSerializer.toJSON(nList);
		return json;
	}

}
