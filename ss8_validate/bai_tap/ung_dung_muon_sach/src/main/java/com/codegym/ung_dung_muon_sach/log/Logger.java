package com.codegym.ung_dung_muon_sach.log;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    private static int count;
    private static int countStockAffect;
    @Before("execution(* com.codegym.ung_dung_muon_sach.controller.*.*(..))")
    public void log(){
        count++;
        System.out.println(count);
    }

    @Before("execution(* com.codegym.ung_dung_muon_sach.controller.RentController.rent(..))||execution(* com.codegym.ung_dung_muon_sach.controller.RentController.returnBook(..)))")
    public void log2(){
        countStockAffect++;
        System.out.println("Hanh dong thay doi so luong sach: "+ countStockAffect);
    }
}
