package camlebell.com.request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import camlebell.com.Utils.Constants;
import camlebell.com.model.ChannelInfo;
import camlebell.com.model.ResultInfo;


/**
 * 登陆
 * 
 * @author 谢晓祥
 * 
 */
public class ChangePasswordRequest extends BaseRequest {

	private String userName;//必填，用户登录名，xx001 领导，13712345678 家长
	private String oldPassword;//必填，用户登录密码，默认123456
	private String newPassword;
	private String appName;//必填，是家长平台app，还是领导平台app，wisdomKitchen_SCHOOL   wisdomKitchen_FAMILY

	public ChangePasswordRequest() {

	}

	public ChangePasswordRequest(String userName, String oldPassword,
								 String newPassword,String appName) {
		this.userName = userName;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
		this.appName = appName;
	}

	@Override
	protected String initService() {
		return "";
	}

	@Override
	protected Object initContent() throws JSONException {
		JSONObject request = new JSONObject();
		try {
			request.put("userName", userName);
			request.put("oldPassword", oldPassword);
			request.put("newPassword", newPassword);
			request.put("appName", appName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return request;
	}

	public String getUrl() {
		return Constants.BASE_URL+Constants.REQUEST_NAME.CHANGE_PASSWORD;
	}

	@Override
	public String toString() {
		try {
			return initContent().toString();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return super.toString();
	}

	/**
	 * 获取数据
	 * 
	 * @return
	 */
	public ResultInfo<ChannelInfo> getChannelList() {
		ResultInfo<ChannelInfo> result = new ResultInfo<ChannelInfo>();

		boolean isSuccess = super.success();
		result.setSuccess(isSuccess);
		if (!isSuccess) {
			result.setrTimeOut(super.isTimeOut());
			result.setFailInfo(super.getMessage());
			return result;
		}
		JSONArray data = getDataArray();
		if (data == null || data.length() == 0) {
			return result;
		}
		List<ChannelInfo> list = new ArrayList<ChannelInfo>();

		for (int i = 0; i < data.length(); i++) {
			JSONObject jo = data.optJSONObject(i);
			ChannelInfo info = new ChannelInfo(jo);
			if (info != null) {
				list.add(info);
			}
		}
		result.setListInfo(list);

		return result;
	}

	/**
	 * 获取数据
	 *
	 * @return
	 */
	public ResultInfo<String> getChangePasswdMessage() {
		ResultInfo<String> result = new ResultInfo<String>();

		boolean isSuccess = super.success();
		result.setSuccess(isSuccess);
		if (!isSuccess) {
			result.setrTimeOut(super.isTimeOut());
			result.setFailInfo(super.getMessage());
			return result;
		}

		return result;
	}

}
