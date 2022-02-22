package models;

public class ComputeEngine {
    private String numberOfInstances;
    private String operatingSystem;
    private String machineClass;
    private String series;
    private String machineType;
    private String gpuType;
    private String numberOfGPU;
    private String localSSD;
    private String datacenterLocation;
    private String committedUsage;

    private ComputeEngine(ComputeEngineBuilder builder) {
        this.numberOfInstances = builder.numberOfInstances;
        this.operatingSystem = builder.operatingSystem;
        this.machineClass = builder.machineClass;
        this.series = builder.series;
        this.machineType = builder.machineType;
        this.gpuType = builder.gpuType;
        this.numberOfGPU = builder.numberOfGPU;
        this.localSSD = builder.localSSD;
        this.datacenterLocation = builder.datacenterLocation;
        this.committedUsage = builder.committedUsage;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }


    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public String getSeries() {
        return series;
    }

    public String getMachineType() {
        return machineType;
    }

    public String getGpuType() {
        return gpuType;
    }

    public String getNumberOfGPU() {
        return numberOfGPU;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public String toString() {
        return "Compute Engine with next parameters: \nnumber of instances is " + numberOfInstances +
                "\n operating system is " + operatingSystem +
                "\n machine class is " + machineClass +
                "\n series is " + series +
                "\n machine type is " + machineType +
                "\n GPU type is " + gpuType +
                "\n number of GPU " + numberOfGPU +
                "\n local SSD is " + localSSD +
                "\n datacenter location is " + datacenterLocation +
                "\n committed usage" + committedUsage;
    }

    public static class ComputeEngineBuilder {
        private String numberOfInstances;
        private String operatingSystem;
        private String machineClass;
        private String series;
        private String machineType;
        private String gpuType;
        private String numberOfGPU;
        private String localSSD;
        private String datacenterLocation;
        private String committedUsage;

        public ComputeEngineBuilder setNumberOfInstances(String value) {
            numberOfInstances = value;
            return this;
        }

        public ComputeEngineBuilder setOperatingSystem(String value) {
            operatingSystem = value;
            return this;
        }

        public ComputeEngineBuilder setMachineClass(String value) {
            machineClass = value;
            return this;
        }

        public ComputeEngineBuilder setSeries(String value) {
            series = value;
            return this;
        }

        public ComputeEngineBuilder setMachineType(String value) {
            machineType = value;
            return this;
        }

        public ComputeEngineBuilder setGpuType(String value) {
            gpuType = value;
            return this;
        }

        public ComputeEngineBuilder setNumberOfGPU(String value) {
            numberOfGPU = value;
            return this;
        }

        public ComputeEngineBuilder setLocalSSD(String value) {
            localSSD = value;
            return this;
        }

        public ComputeEngineBuilder setDatacenterLocation(String value) {
            datacenterLocation = value;
            return this;
        }

        public ComputeEngineBuilder setCommittedUsage(String value) {
            committedUsage = value;
            return this;
        }

        public ComputeEngine build() {
            return new ComputeEngine(this);
        }
    }
}