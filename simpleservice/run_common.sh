while [[ $# -gt 1 ]]
do
key="$1"

case $key in
    -n|--name-prefix)
    CONTAINER_PREFIX="$2"
    shift # past argument
    ;;
    *)
            # unknown option
    ;;
esac
shift # past argument or value
done

export CONTAINER_PREFIX

docker stop ${CONTAINER_PREFIX}_fortune_1
docker rm ${CONTAINER_PREFIX}_fortune_1

docker stop ${CONTAINER_PREFIX}_fortune_2
docker rm ${CONTAINER_PREFIX}_fortune_2

docker stop ${CONTAINER_PREFIX}_mysqldb_1
docker rm ${CONTAINER_PREFIX}_mysqldb_1

docker stop ${CONTAINER_PREFIX}_web_1
docker rm ${CONTAINER_PREFIX}_web_1

docker-compose build