package apim.github.tutorial;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

	@RequestMapping("/get.form")
	public String processGet(@RequestParam int ip1, @RequestParam int ip2, Map<String, Object> model) {
		model.put("message", ip1 + ip2);
		return "show_message";
	}

	@RequestMapping("/post.form")
	public String processPost(@ModelAttribute Numbers ip, Map<String, Object> model) {
		model.put("message", ip.getIp1() + ip.getIp2());
		return "show_message";
	}

	@RequestMapping("/pvtest.form/{val}")
	public String processPV(@PathVariable int val, Map<String, Object> model) {
		String result = val % 2 == 0 ? "Even Number" : "Odd Number";
		model.put("message", result);
		return "show_message";
	}

}
