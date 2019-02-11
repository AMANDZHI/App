CREATE TABLE project_tbl (
  projectId varchar(30) NOT NULL,
  name varchar(30) NOT NULL,
  description varchar(50) NOT NULL,
  userId varchar(30) NOT NULL,
  PRIMARY KEY (projectId),
  FOREIGN KEY (userId) REFERENCES user_tbl
);

CREATE TABLE task_tbl (
  taskId varchar(30) NOT NULL,
  name varchar(30) NOT NULL,
  description varchar(50) NOT NULL,
  projectId varchar(30) NOT NULL,
  PRIMARY KEY (taskId),
  FOREIGN KEY (projectId) REFERENCES project_tbl
);

CREATE TABLE user_tbl (
  userId varchar(30) NOT NULL,
  name varchar(30) NOT NULL,
  login varchar(30) NOT NULL,
  password varchar(30) NOT NULL,
  admin varchar(5) NOT NULL,
  PRIMARY KEY (userId)
);