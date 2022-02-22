package models;

public class ComputeEngineCreator {

    public static ComputeEngine createBasicComputeEngine() {
        ComputeEngine computeEngine = new ComputeEngine.ComputeEngineBuilder().setNumberOfInstances("4")
                .setOperatingSystem("Free: Debian, CentOS, CoreOS, Ubuntu or BYOL")
                .setMachineClass("Regular")
                .setSeries("N1")
                .setMachineType("n1-standard-8 (vCPUs: 8, RAM: 30GB)")
                .setGpuType("NVIDIA Tesla V100")
                .setNumberOfGPU("1")
                .setLocalSSD("2x375 GB")
                .setDatacenterLocation("Frankfurt (europe-west3)")
                .setCommittedUsage("1 Year")
                .build();
        return computeEngine;
    }
}