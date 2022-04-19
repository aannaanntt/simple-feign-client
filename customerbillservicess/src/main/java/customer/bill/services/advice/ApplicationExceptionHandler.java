package customer.bill.services.advice;

import java.util.HashMap;
import java.util.Map;

import javax.validation.UnexpectedTypeException;
import javax.validation.constraints.NotBlank;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ctc.wstx.shaded.msv_core.grammar.UnaryExp;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleInvalidArgument(MethodArgumentNotValidException ex){
		
		Map<String,String> errorMap=new HashMap<>();
		
		ex.getBindingResult().getFieldErrors().forEach(error->{
			errorMap.put(error.getField(),error.getDefaultMessage());
		});
		
		return errorMap;
	}
	
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(UnexpectedTypeException.class)
	public Map<String,String> handleInvalidArgument(UnexpectedTypeException   ex){
		
		Map<String,String> errorMap=new HashMap<>();
		
		errorMap.put("error message", ex.getMessage());
		errorMap.put("error cause", ex.getCause().toString());
		return errorMap;
	}
	
	
	
	
}
