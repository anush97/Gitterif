package Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import com.fasterxml.jackson.databind.JsonNode;

import Models.GithubResult;

public class Cache {
	private Map<String, JsonNode> cache;
		public Cache() { 
			cache = new HashMap<>();
		}
		public void put(String key,JsonNode results) {
			cache.putIfAbsent(key, results);
		}
				
		public JsonNode get(String key){
			return cache.get(key);
		}	
		public CompletionStage<JsonNode> getOrElseUpdate(String key,Callable<CompletionStage<JsonNode>> block){
			if(!this.get(key).isEmpty()) {
				return CompletableFuture.supplyAsync(()-> this.get(key));
			}else {
				try {
					return block.call().thenApplyAsync(issues->{	
						this.put(key, issues);
						return issues;
					});
				} catch (Exception e) {
					e.printStackTrace();
					return CompletableFuture.supplyAsync(()-> null);
				}
			}
		}
	}
