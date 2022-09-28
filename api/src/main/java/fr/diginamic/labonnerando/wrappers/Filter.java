package fr.diginamic.labonnerando.wrappers;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Filter<T> {

	private T subject;
	private Map<String, Object> filters;
}
