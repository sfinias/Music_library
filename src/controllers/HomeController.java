package controllers;

import dao.DBAccess;
import dao.Helper;
import model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import java.io.File;
import java.io.IOException;
import java.util.List;

@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@Controller
public class HomeController  {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String home(ModelMap modelMap, @RequestParam ("file") final MultipartFile musicFile) {
        String fileName = musicFile.getOriginalFilename();
        if (!fileName.endsWith(".mp3")) return "redirect:lib.htm";
        File file = new File(fileName);

        try {
            if(!file.exists()){
                musicFile.transferTo(file);
            }
            Helper helper = new Helper(file);
            modelMap.addAttribute("name", helper.getCover());
            helper.addSong();
        } catch (IOException e) {
        }
        file.delete();
        return "redirect:lib.htm";
    }

    @RequestMapping(value = "/lib", method = RequestMethod.GET)
    public String car(ModelMap modelMap){
        List<Song> songs = DBAccess.getSongs();
        modelMap.addAttribute("songs", songs);
        return "library";
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public String del(@RequestParam("artist")String artist, @RequestParam("title") String title){
        DBAccess.deleteSong(artist, title);
        return "redirect:lib.htm";
    }
}
