package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
//@RequestMapping("/users")
public class MainController {

    private UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public ModelAndView allUsers() {
        List<User> users = userService.allUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user");
        modelAndView.addObject("userList", users);
        return modelAndView;
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView editPage(@PathVariable("id") Integer id) {
        User user = userService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping(value = "/edit")
    public ModelAndView editUser(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/user");
        userService.edit(user);
        return modelAndView;
    }

    @GetMapping(value = "/add")
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public ModelAndView addUser(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/user");
        userService.add(user);
        return modelAndView;
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/user");
        User user = userService.getById(id);
        userService.delete(user);
        return modelAndView;
    }

}
//public class UsersControllers {
//    @Autowired
//    public UsersControllers(UserDao userDao) {
//        this.userDao = userDao;
//    }
//
//    private UserDao userDao;
//
//
//    @GetMapping()
//    public String index(Model model) {
//        model.addAttribute("users",userDao.index());
//        return "users/index";
//    }
//
//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") int id, Model model) {
//        model.addAttribute("user",userDao.show(id));
//        return "users/show";
//    }
//    @GetMapping("/new")
//    public String newUser(@ModelAttribute("user")User user){
//        return "users/new";
//    }
//    @PostMapping()
//    public String create(@ModelAttribute("user")User user){
//        userDao.save(user);
//        return "redirect:/users";
//    }
//    @GetMapping("/{id}/edit")
//    public String edit(Model model,@PathVariable("id") int id){
//        model.addAttribute("user",userDao.show(id));
//        return  "users/edit";
//    }
//    @PatchMapping("/{id}")
//    public String update(@ModelAttribute("user")User user,@PathVariable("id") int id){
//        userDao.update(id,user);
//        return "redirect:/users";
//    }
//
//}
