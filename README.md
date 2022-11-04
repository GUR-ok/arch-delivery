Микросервис Доставки

Сборка и установка в minikube
1) `gradle build`
2) `docker build -t gurok/arch_delivery .`
3) `docker push gurok/arch_delivery`
4) `kubectl create namespace arch-gur`
5) `helm install gorelov-kafka ./deployment/kafka/`
6) `helm install arch-delivery ./deployment/app/`
   `kubectl get pods -n arch-gur`
   
---

Для локального поднятия кафки: `docker-compose-kafka up`

---
### Очистка пространства:

- `helm uninstall arch-delivery`
- `kubectl delete namespace arch-gur`
- `helm uninstall gorelov-kafka`