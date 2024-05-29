package com.cooltoor;

import java.util.ArrayList;
import java.io.*;

public class NavigationInstructions {
    ArrayList<String> instructions;
    ArrayList<Location> nodes;

    public NavigationInstructions(ArrayList<String> instructions, ArrayList<Location> nodes) {
        this.instructions = instructions;
        this.nodes = nodes;
    }

    public ArrayList<String> getInstructions() {
        return this.instructions;
    }

    public ArrayList<Location> getNodes() {
        return this.nodes;
    }
}
