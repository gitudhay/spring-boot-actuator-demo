# Spring Boot Actuator Demo Application
This is a Spring Boot Actuator Demo Application with Prometheus and Grafana for application monitoring.

- Spring Boot Version: 2.5.6
- Prometheus Version: 3.5.0
- Grafana Version: 12.1.1

## Prometheus:
Download URL: https://prometheus.io/download/

### Prometheus Configuration:

- Edit /home/local/BSILIND/udhayakumar.g/Softwares/Prometheus/prometheus-3.5.0.linux-amd64/prometheus.yml
- Under the scrape_configs section, add the following:

<pre>
- job_name: "spring-boot-actuator-demo"
  # metrics_path defaults to '/metrics'
  metrics_path: '/actuator/prometheus'
  scrape_interval: 5s
  # scheme defaults to 'http'.
  static_configs:
  - targets: ["localhost:8080"]
  # The label name is added as a label to any time series scraped from this config.
      labels:
        app: "prometheus"
</pre>

### service start script:
cd /home/local/BSILIND/udhayakumar.g/Softwares/Prometheus/prometheus-3.5.0.linux-amd64/
<br/>
./prometheus

URL: http://localhost:9090/
admin/admin
