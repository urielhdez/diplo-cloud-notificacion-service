use admin;
db.createUser(
{
	user: "notificacion_owner",
	pwd: "notificacion_password",
	roles: [ { role: "userAdmin", db: "notificaciondb" }]
});
