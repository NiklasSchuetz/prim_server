package com.vs_prim.restservice;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PrimzahlenController {

	@GetMapping("/string")
	public String prim_string(@RequestParam(value = "nr") int nr) {
		return Primzahlen.compute_Prime(nr).toString().replace("[","").replace("]","");
	}


	@GetMapping("/array")
	public String  prim_array(@RequestParam(value = "nr") int nr) {
		List<Integer> list = Primzahlen.compute_Prime(nr);

		JSONArray json_arr = new JSONArray();

		for (int i = 0; i < list.size(); i++) {
			json_arr.put(list.get(i));
		}

		JSONObject obj = new JSONObject();
		obj.put("array", json_arr);

		return obj.toString();
	}


	@GetMapping("/struct")
	public String prim_struct(@RequestParam(value = "nr") int nr) {
		JSONObject obj = new JSONObject();
		obj.put("array",Primzahlen.compute_Prime(nr));
		obj.put("string",Primzahlen.compute_Prime(nr).toString());
		return obj.toString();
	}


}
