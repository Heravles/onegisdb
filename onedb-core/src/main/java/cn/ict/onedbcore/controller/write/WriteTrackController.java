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
import cn.ict.onedbcore.entity.db.Track;



@RestController
@RequestMapping("/api/write")
public class WriteTrackController {
	
	public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	TrackDao trackDao;
	
	@RequestMapping(method = RequestMethod.POST, value = "/track")
	@Consumes(MediaType.TEXT_PLAIN)
	public List<Track> writeDobjects(InputStream incomingData) {
		List<Track> result = new ArrayList<>();
        Boolean skipFirst = true;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
            String line = null;
            while((line = in.readLine()) != null) {
            	if (skipFirst) {
            		skipFirst = false;
            		continue;
            	}
            	Track track = new Track();
            	String[] str = line.split("\\s+");
            	track.setOid(Long.valueOf(str[0]).longValue());
            	track.setX(Double.valueOf(str[1]).doubleValue());
            	track.setY(Double.valueOf(str[2]).doubleValue());
            	track.setZ(Double.valueOf(str[3]).doubleValue());
            	track.setTime(Long.valueOf(str[4]).longValue());
            	result.add(track);
            }
        } catch(Exception e) {
            System.out.println("Error Parsing: - ");
        }
        System.out.println("Data Received: " + result);

        return trackDao.saveAll(result);
	}
}
