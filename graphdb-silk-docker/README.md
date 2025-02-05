# GraphDB y Silk

Este repositorio Docker incluye los servicios GraphDB y Silk, enlazados entre sí, para poder usar Silk para descubrimiento de enlaces, combinando los datos que residen en GraphDB con datos externos (Ej. DBPedia).

## Ejecución

Levantar los servicios:

```bash
docker-compose up
```

Esto debería levantar los dos servicios en localhost 7200 (GraphDB) y 81 (Silk). Los puertos y volumenes se pueden configurar en el archivo `docker-compose.yml` (Ambos servicios persisten los datos en los volumenes).

En GraphDB, conectar el repositorio `NORA-links`. En Silk, el proyecto `NORA-links-tests` (Importarlo de `Linked-Data-fase-2/graphdb-silk-docker/silk-workspaces/NORA-links-tests.zip` si fuera necesario) incluye una configuración con GraphDB, y DBPedia.

## Problema al actualizar a Ubuntu 22.04.01 LTS

Docker no funciona al actualizar a Ubuntu por que no monta los cgroups. Solucion temporal:

```bash
mkdir /sys/fs/cgroup/systemd
mount -t cgroup -o none,name=systemd cgroup /sys/fs/cgroup/systemd
```

Añadir la linea a `/etc/fstab`:

```bash
cgroup    /sys/fs/cgroup/systemd    cgroup    defaults
```

Pero no funciona por que se borra el directorio cada vez. Esto si funciona:

```
echo "GRUB_CMDLINE_LINUX=systemd.unified_cgroup_hierarchy=false" | sudo tee /etc/default/grub.d/cgroup.cfg
sudo update-grub
``