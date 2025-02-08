package com.example.demo.ifaces;

import java.util.ArrayList;

import com.example.demo.model.Radioteleskopi;

public interface IRadioteleskopi {

	public abstract ArrayList<Radioteleskopi> select() throws Exception;
}
