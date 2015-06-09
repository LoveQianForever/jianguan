package ${package}.modules.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import ${package}.core.base.action.BaseAction;
import ${package}.core.base.search.Search;
import ${package}.modules.model.${className};
import ${package}.modules.service.${className}Service;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class ${className}Action extends BaseAction implements ModelDriven<${className}>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private ${className}Service ${className1}Service;
	
	private ${className} ${className1} = new ${className}();
	
	public ${className} get${className}() {
		return ${className1};
	}
	
	@Override
	public ${className} getModel() {
		return ${className1};
	}
	
	@Action(value = "/${className1}", results = {
			@Result(name = SUCCESS, location = "/admin/${className1}/${className1}list.jsp")
	})
	
	@Override
	public String execute() {
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		Search search = new Search(${className}.class);
		search = this.getSearch(search);
		
		/*根据前台条件生成对应属性判断条件*/

		int count = ${className1}Service.count(search);
		List<${className}> list = ${className1}Service.searchAll(search);
		List<Map<String, Object>> ${className1}List = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				${className} obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", obj.getId());
				row.put("cell",
						new Object[] { obj.getId() });//其他属性需按页面需要填写
				${className1}List.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, ${className1}List);

		sendMessages(httpServletResponse, json.toString());

		return null;
	}
}