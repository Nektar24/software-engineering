package com.cooltoor;

import com.graphhopper.GHRequest;
import com.graphhopper.GHResponse;
import com.graphhopper.GraphHopper;
import com.graphhopper.config.Profile;
import com.graphhopper.routing.util.EncodingManager;
import com.graphhopper.util.shapes.GHPoint;
import com.graphhopper.util.Instruction;
import com.graphhopper.util.InstructionList;

import java.util.ArrayList;
import java.util.List;

public class NavigationManager {

    private static GraphHopper graphHopper;

    static {
        graphHopper = new GraphHopper();
        graphHopper.setProfiles(new Profile("car").setVehicle("car").setWeighting("fastest"),
                                new Profile("foot").setVehicle("foot").setWeighting("fastest"));
        graphHopper.getCHPreparationHandler().setCHProfiles(new Profile("car"), new Profile("foot"));
        graphHopper.setGraphHopperLocation("graphhopper/graph-cache");
        graphHopper.importOrLoad();
    }

    public static ArrayList<String> requestHistoricWalkInstructions(List<Location> points) {
        ArrayList<String> instructions = new ArrayList<>();
        
        if (points.size() < 2) {
            return instructions;
        }
        
        for (int i = 0; i < points.size() - 1; i++) {
            Location start = points.get(i);
            Location end = points.get(i + 1);

            GHPoint startPoint = new GHPoint(start.get(0), start.get(1));
            GHPoint endPoint = new GHPoint(end.get(0), end.get(1));

            GHRequest request = new GHRequest(startPoint, endPoint)
                    .setProfile("foot")
                    .setLocale("en");

            GHResponse response = graphHopper.route(request);

            if (response.hasErrors()) {
                for (Throwable error : response.getErrors()) {
                    System.err.println(error.getMessage());
                }
                continue;
            }

            InstructionList il = response.getBest().getInstructions();
            for (Instruction instruction : il) {
                instructions.add(instruction.getTurnDescription(graphHopper.getTranslationMap().getWithFallBack("en")));
            }
        }

        return instructions;
    }

    public static ArrayList<String> requestInstructions(Location start, Location end) {
        ArrayList<String> instructions = new ArrayList<>();
        
        GHPoint startPoint = new GHPoint(start.get(0), start.get(1));
        GHPoint endPoint = new GHPoint(end.get(0), end.get(1));

        GHRequest request = new GHRequest(startPoint, endPoint)
                .setProfile("car")
                .setLocale("en");

        GHResponse response = graphHopper.route(request);

        if (response.hasErrors()) {
            for (Throwable error : response.getErrors()) {
                System.err.println(error.getMessage());
            }
            return instructions;
        }

        InstructionList il = response.getBest().getInstructions();
        for (Instruction instruction : il) {
            instructions.add(instruction.getTurnDescription(graphHopper.getTranslationMap().getWithFallBack("en")));
        }

        return instructions;
    }
}

