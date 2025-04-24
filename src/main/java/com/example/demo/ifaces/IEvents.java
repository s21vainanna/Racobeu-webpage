package com.example.demo.ifaces;

import java.util.ArrayList;

import com.example.demo.model.Events;

public interface IEvents {

	public abstract ArrayList<Events> selectall() throws Exception;
}
