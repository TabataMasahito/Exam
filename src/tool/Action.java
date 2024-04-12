package tool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Action{
	public abstract void excute(HttpServletRequest request,HttpServletResponse response) throws Exception;
}