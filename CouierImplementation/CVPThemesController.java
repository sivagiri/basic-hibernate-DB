package com.arista.cvp.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.arista.cvp.commons.constants.Constants;
import com.arista.cvp.commons.exceptions.CVPException;
import com.arista.cvp.commons.exceptions.ErrorCode;
import com.arista.cvp.commons.logging.CVPLogger;
import com.arista.cvp.commons.moduleaccess.APIPathConstants;
import com.arista.cvp.commons.utils.CommonUtils;
import com.arista.cvp.web.restadapter.BaseAdapter;
import com.arista.cvp.web.utils.CVPWebUtils;
import com.arista.cvp.web.utils.MethodNameHelper;

/**
 * This controller is specific for background images and logo related operations .
 *
 * @author karthikeyan.vs
 */
@Controller
@RequestMapping(APIPathConstants.CVP_THEME)
public class CVPThemesController {
	
	/**
	 * log for CVPInfo Controller.
	 */
	private static final CVPLogger LOGGER = new CVPLogger(CVPThemesController.class);

	/**
	 * BaseAdapter to handle rest service.
	 */
	@Autowired
	private BaseAdapter baseAdapter;
	
	/**
	 * This method is used to add the themes to cvp
	 *
	 * @param file 
	 * 			the file
	 * @param type 
	 * 			the type
	 * @param httpRequest 
	 * 			the http request
	 * @param httpResponse 
	 * 			the http response
	 * @return response
	 */
	@RequestMapping(value = "/addCvpThemes", method = RequestMethod.POST)
	@ResponseBody
	public final String addCvpThemes(
			@RequestParam(Constants.IMAGE) MultipartFile file,
			@RequestParam(Constants.TYPE) String type,
			HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		ResponseEntity<String> responseFromService = null;
		String addThemeResponse = null;
		final String methodName = MethodNameHelper
				.getMethodName(Constants.ZERO);
		final String relativeURL = CVPWebUtils.getRelativePath(httpRequest
				.getRequestURI());
		final StringBuilder message = new StringBuilder();
		message.append("Adding the Background image to cvp");
		try {
			if (!isValidType(type)) {
				throw new CVPException(
						ErrorCode.INVALID_TYPE.getErrorCode(),
						ErrorCode.INVALID_TYPE.getErrorMessage());
			}
			if (!isValidImage(file)) {
				throw new CVPException(ErrorCode.INVALID_IMAGE.getErrorCode(),
						ErrorCode.INVALID_IMAGE.getErrorMessage());
			}
			if (!isValidSize(file, type)) {
				throw new CVPException(ErrorCode.INVALID_SIZE.getErrorCode(),
						ErrorCode.INVALID_SIZE.getErrorMessage());
			}
			LOGGER.logDebug(Constants.ENTER, methodName, message.toString());
			byte[] bytes = file.getBytes();

			HttpEntity<?> requestEntity = new HttpEntity<>(bytes, null);
			responseFromService = this.baseAdapter.makeRequest(
					HttpMethod.POST,
					requestEntity,
					new StringBuilder(relativeURL)
							.append(Constants.QUESTION_MARK)
							.append(Constants.TYPE)
							.append(Constants.EQUALS.trim()).append(type)
							.toString(),
					String.class, null);
			addThemeResponse = responseFromService.getBody();
			LOGGER.logDebug(Constants.EXIT, methodName, addThemeResponse);

		} catch (RuntimeException runtimeException) {
			LOGGER.logRuntimeError(runtimeException);
			addThemeResponse = CVPWebUtils
					.buildRuntimeException(ErrorCode.CVPTHEMES_MODULE.getId());
		} catch (IOException e) {
			addThemeResponse = CVPWebUtils
					.buildIOException(ErrorCode.CVPTHEMES_MODULE.getId());
			LOGGER.logRuntimeError(e);
		}catch (CVPException exception) {
			LOGGER.logRuntimeError(exception);
			addThemeResponse = CVPWebUtils
					.buildException(ErrorCode.CVPTHEMES_MODULE.getId(),exception.getErrorCode());
		}catch (Exception exception) {
			LOGGER.logRuntimeError(exception);
			addThemeResponse = CVPWebUtils
					.buildRuntimeException(ErrorCode.CVPTHEMES_MODULE.getId());
		}
		return addThemeResponse;
	}
	
	private boolean isValidImage(MultipartFile file) {
		return "image/png".equals(file.getContentType())
				|| "image/jpeg".equals(file.getContentType())
				|| "image/gif".equals(file.getContentType());
	}

	private boolean isValidSize(MultipartFile file, String type) {
		return !(file.getSize() > (long) 200000);
	}
	
	private boolean isValidType(String type) {
		return Constants.BACKGROUND_IMAGE.equals(type) || Constants.LOGO.equals(type);
	}
	/**
	 * This method is used to apply cvpthemes to cvp
	 *
	 * @param uniqueIdJson 
	 * 			the unique id json
	 * @param httpRequest 
	 * 			the http request
	 * @param httpResponse 
	 * 			the http response
	 * @return response
	 */
	@RequestMapping(value = "/applyCvpthemes", method = RequestMethod.POST)
	@ResponseBody
	public final String applyCvpthemes(@RequestBody String uniqueIdJson,
			HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		final String methodName = "applyCvpthemes";
		String response = null;
		final String relativeURL = CVPWebUtils.getRelativePath(httpRequest
				.getRequestURI());
		try {
			final HttpEntity<String> requestEntity = new HttpEntity<>(
					uniqueIdJson, new HttpHeaders());
			final ResponseEntity<Object> responsefromService = this.baseAdapter
					.makeRequest(HttpMethod.POST, requestEntity, relativeURL,
							String.class);
			response = (String) responsefromService.getBody();
			LOGGER.logDebug(Constants.EXIT, methodName, response);
		} catch (RuntimeException runtimeexception) {
			LOGGER.logRuntimeError(runtimeexception);
			response = CVPWebUtils.buildRuntimeException(ErrorCode.CVPTHEMES_MODULE
					.getId());
		} catch (Exception exception) {
			LOGGER.logRuntimeError(exception);
			response = CVPWebUtils.buildRuntimeException(ErrorCode.CVPTHEMES_MODULE
					.getId());
		}
		return response;
	}
	
	/**
	 * This method is used to Get the all cvp themes.
	 *
	 * @param httpRequest 
	 * 			the http request
	 * @param httpResponse 
	 * 			the http response
	 * @return the all cvp themes
	 */
	@RequestMapping(value = "/getAllCvpThemes", method = RequestMethod.GET)
	@ResponseBody
	public final String getAllCvpThemes(
			@RequestParam(value = Constants.TYPE, defaultValue = Constants.ALL) String type,
			@RequestParam(Constants.START_INDEX) int startIndex,
			@RequestParam(Constants.END_INDEX) int endIndex,
			HttpServletRequest httpRequest, 
			HttpServletResponse httpResponse) {
		final String methodName = "getAllCvpThemes";
		String response = null;
		try {
			LOGGER.logDebug(Constants.ENTER, methodName, Constants.EMPTY);
			final String relativeURL = CVPWebUtils.getRelativePath(httpRequest
					.getRequestURI());
			final StringBuilder relativeURLBuilder = new StringBuilder(
					relativeURL);
			final ResponseEntity<Object> responsefromService = this.baseAdapter
					.makeRequest(HttpMethod.GET, null,
							relativeURLBuilder.append(Constants.QUESTION_MARK)
									.append(Constants.TYPE)
									.append(Constants.EQUALS.trim())
									.append(type).append(Constants.AMPERSAND)
									.append(Constants.START_INDEX)
									.append(Constants.EQUALS.trim())
									.append(startIndex)
									.append(Constants.AMPERSAND)
									.append(Constants.END_INDEX)
									.append(Constants.EQUALS.trim())
									.append(endIndex).toString(), String.class);
			response = (String) responsefromService.getBody();
			LOGGER.logDebug(Constants.EXIT, methodName, response);
		} catch (RuntimeException runtimeexception) {
			LOGGER.logRuntimeError(runtimeexception);
			response = CVPWebUtils.buildRuntimeException(ErrorCode.CVPTHEMES_MODULE
					.getId());
		} catch (Exception exception) {
			LOGGER.logRuntimeError(exception);
			response = CVPWebUtils.buildRuntimeException(ErrorCode.CVPTHEMES_MODULE
					.getId());
		}
		return response;
	}

	
	/**
	 * This method is used to Delete themes.
	 *
	 * @param uniqueIdJson 
	 * 			the unique id json
	 * @param httpRequest 
	 * 			the http request
	 * @param httpResponse 
	 * 			the http response
	 * @return response
	 */
	@RequestMapping(value = "/deleteThemes", method = RequestMethod.POST)
	@ResponseBody
	public final String deleteThemes(@RequestBody String uniqueIdJson,
			HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		final String methodName = "deleteBackgroundImage";
		String response = null;
		final String relativeURL = CVPWebUtils.getRelativePath(httpRequest
				.getRequestURI());
		try {
			final HttpEntity<String> requestEntity = new HttpEntity<>(
					uniqueIdJson, new HttpHeaders());
			final ResponseEntity<Object> responsefromService = this.baseAdapter
					.makeRequest(HttpMethod.POST, requestEntity, relativeURL,
							String.class);
			response = (String) responsefromService.getBody();
			LOGGER.logDebug(Constants.EXIT, methodName, response);
		} catch (RuntimeException runtimeexception) {
			LOGGER.logRuntimeError(runtimeexception);
			response = CVPWebUtils.buildRuntimeException(ErrorCode.CVPTHEMES_MODULE
					.getId());
		} catch (Exception exception) {
			LOGGER.logRuntimeError(exception);
			response = CVPWebUtils.buildRuntimeException(ErrorCode.CVPTHEMES_MODULE
					.getId());
		}
		return response;
	}


	/**
	 * This method is used to get the active theme.
	 * @param httpRequest 
	 * 			the http request
	 * @param httpResponse 
	 * 			the http response
	 * @return the active theme
	 */
	@RequestMapping(value = "/getActiveTheme", method = RequestMethod.POST)
	@ResponseBody
	public final String getActiveTheme(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		final String methodName = "getActiveTheme";
		String response = null;
		final String relativeURL = CVPWebUtils.getRelativePath(httpRequest
				.getRequestURI());
		try {
			final HttpEntity<String> requestEntity = new HttpEntity<>(
					null, new HttpHeaders());
			final ResponseEntity<Object> responsefromService = this.baseAdapter
					.makeRequest(HttpMethod.POST, requestEntity, relativeURL,
							String.class);
			response = (String) responsefromService.getBody();
			LOGGER.logDebug(Constants.EXIT, methodName, response);
		} catch (RuntimeException runtimeexception) {
			LOGGER.logRuntimeError(runtimeexception);
			response = CVPWebUtils.buildRuntimeException(ErrorCode.CVPTHEMES_MODULE
					.getId());
		} catch (Exception exception) {
			LOGGER.logRuntimeError(exception);
			response = CVPWebUtils.buildRuntimeException(ErrorCode.CVPTHEMES_MODULE
					.getId());
		}
		return response;
	}	
	
	/**
	 *
	 * @param baseAdapter
	 *            the new base adapter
	 */
	public final void setBaseAdapter(BaseAdapter baseAdapter) {
		this.baseAdapter = baseAdapter;
	}
	
	
}
