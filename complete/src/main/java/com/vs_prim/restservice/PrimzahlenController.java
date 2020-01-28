package com.vs_prim.restservice;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.jackson.JsonObjectDeserializer;
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
	public JSONObject  prim_array(@RequestParam(value = "nr") int nr) {
		List<Integer> list = Primzahlen.compute_Prime(nr);

		JSONArray json_arr = new JSONArray();

		for (int i = 0; i < list.size(); i++) {
			json_arr.put(list.get(i));
		}

		JSONObject obj = new JSONObject();
		obj.put("array", json_arr);

		return obj;
	}


	@GetMapping("/struct")
	public Primzahlen prim_struct(@RequestParam(value = "nr") int nr) {
		return new Primzahlen(Primzahlen.compute_Prime(nr), Primzahlen.compute_Prime(nr).toString());
	}


}
