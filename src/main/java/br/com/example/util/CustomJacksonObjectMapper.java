package br.com.example.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class CustomJacksonObjectMapper extends ObjectMapper {
	
	private static final long serialVersionUID = 1L;
	
	private final String mask = "yyyy-MM-dd HH:mm:ss";
	
	@PostConstruct 
	public void afterProps(){
		configure();
	}
	
	public static ObjectMapper build(){
		return new CustomJacksonObjectMapper().configure();
	}
	
	private ObjectMapper configure(){
		configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
		configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
		setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		setSerializationInclusion(Include.NON_NULL);
		
		SimpleModule module = new SimpleModule("DateModule");
		module.addSerializer(Date.class, new JsonSerializer<Date>(){

			@Override
			public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
				SimpleDateFormat df = new SimpleDateFormat(mask);
				String data = df.format(value);
				jgen.writeString(data);
			}
		});
		
		this.registerModule(module);
		
		return this;
	}
}