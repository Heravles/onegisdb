package cn.ict.onedbcore.controller.write;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.ict.onedbcore.dao.TrackDao;
import cn.ict.onedbcore.entity.db.TrackData;
import cn.ict.onedbcore.error.ResultResponse;



@RestController
@RequestMapping("/api/write")
public class WriteTrackController {
	
	public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	TrackDao trackDao;
	
	@RequestMapping(method = RequestMethod.POST, value = "/track")
	@Consumes(MediaType.TEXT_PLAIN)
	public ResultResponse<Long> writeTrackLong(InputStream incomingData) {
        Boolean skipFirst = true;
		List<TrackData> resultLists = new ArrayList<>();
		ResultResponse<Long> result = new ResultResponse<Long>("trackdata");
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
            String line = null;
            while((line = in.readLine()) != null) {
            	if (skipFirst) {
            		skipFirst = false;
            		continue;
            	}
            	TrackData trackdata = new TrackData();
            	String[] str = line.split("\\s+");
            	trackdata.setTrackData(str);
            	resultLists.add(trackdata);
            }
		} catch (Exception e) {
			result.setSuccess(false);
			Throwable cause = e.getCause();
		    if(cause instanceof org.hibernate.exception.ConstraintViolationException) {
		        String errMsg = 
		        		((org.hibernate.exception.ConstraintViolationException)cause).
		        		getSQLException().getMessage();
		        result.setMessage(errMsg);
		    } else {
		    	result.setMessage(e.getMessage());
		    }
		} finally {
			result.setCount(resultLists.size());
			if (result.getCount() > 0) {
				result.setSamplekey(resultLists.get(0).getIndentity().getOid());
			}
		}
		return result;
	}
	@RequestMapping(method = RequestMethod.POST, value = "/shorttrack")
	@Consumes(MediaType.TEXT_PLAIN)
	public ResultResponse<Long> writeTrackShort(InputStream incomingData) {
        Boolean skipFirst = true;
		List<TrackData> resultLists = new ArrayList<>();
		ResultResponse<Long> result = new ResultResponse<Long>("trackdata_short");
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
            String line = null;
            while((line = in.readLine()) != null) {
            	if (skipFirst) {
            		skipFirst = false;
            		continue;
            	}
            	TrackData trackdata = new TrackData();
            	String[] str = line.split("\\s+");
            	trackdata.setTrackDataShort(str);
            	resultLists.add(trackdata);
            }
		} catch (Exception e) {
			result.setSuccess(false);
			Throwable cause = e.getCause();
		    if(cause instanceof org.hibernate.exception.ConstraintViolationException) {
		        String errMsg = 
		        		((org.hibernate.exception.ConstraintViolationException)cause).
		        		getSQLException().getMessage();
		        result.setMessage(errMsg);
		    } else {
		    	result.setMessage(e.getMessage());
		    }
		} finally {
			result.setCount(resultLists.size());
			if (result.getCount() > 0) {
				result.setSamplekey(resultLists.get(0).getIndentity().getOid());
			}
		}
		return result;
	}
}
