//package com.company.actions;
//
//import com.company.api.Action;
//import com.company.api.ServiceLocator;
//import com.company.model.User;
//import com.company.util.ActionRole;
//import lombok.SneakyThrows;
//
//import java.io.IOException;
//import java.util.Optional;
//
//public class UserRemoveAction implements Action {
//    private ServiceLocator serviceLocator;
//
//    @Override
//    public String getName() {
//        return "removeUser";
//    }
//
//    @Override
//    public String getDescription() {
//        return "removeByLogin user";
//    }
//
//    @Override
//    @SneakyThrows
//    public void execute() {
//        String answerLoginUser = CommonReader.getLoginUser();
//
//        Optional<User> optionalUser = serviceLocator.getUserServiceDB().findByLogin(answerLoginUser);
//        if (optionalUser.isPresent()) {
//            if (!optionalUser.get().equals(serviceLocator.getSessionService().getSession().getUser())) {
//                if (serviceLocator.getUserServiceDB().removeByLogin(answerLoginUser)) {
//                    System.out.println("Удален юзер");
//                } else {
//                    System.out.println("Не удалось удалить юзера из базы");
//                }
//            } else {
//                System.out.println("Нельзя удалить себя");
//            }
//        } else {
//            System.out.println("Нет такого юзера");
//        }
//    }
//
//    @Override
//    public ActionRole getRole() {
//        return ActionRole.ADMIN;
//    }
//
//    @Override
//    public void setServiceLocator(ServiceLocator serviceLocator) {
//        this.serviceLocator = serviceLocator;
//    }
//}