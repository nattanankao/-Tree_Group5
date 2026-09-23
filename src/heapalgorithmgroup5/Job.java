package heapalgorithmgroup5;

public class Job {
    private final String jobId;
    private final String jobName;
    private int priority;
    private final String arrivalTime;
    private final int estimatedTime;

    public Job(String jobId, String jobName, int priority,
               String arrivalTime, int estimatedTime) {
        if (jobId == null || jobId.isBlank()) {
            throw new IllegalArgumentException("Job ID must not be empty");
        }
        if (jobName == null || jobName.isBlank()) {
            throw new IllegalArgumentException("Job name must not be empty");
        }
        if (priority < 0) {
            throw new IllegalArgumentException("Priority must be >= 0");
        }
        if (estimatedTime < 0) {
            throw new IllegalArgumentException("Estimated time must be >= 0");
        }

        this.jobId = jobId;
        this.jobName = jobName;
        this.priority = priority;
        this.arrivalTime = arrivalTime == null ? "" : arrivalTime;
        this.estimatedTime = estimatedTime;
    }

    public String getJobId() {
        return jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public int getPriority() {
        return priority;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public void setPriority(int priority) {
        if (priority < 0) {
            throw new IllegalArgumentException("Priority must be >= 0");
        }
        this.priority = priority;
    }

    @Override
    public String toString() {
        return jobId + "(" + jobName + ", P=" + priority + ")";
    }
}
