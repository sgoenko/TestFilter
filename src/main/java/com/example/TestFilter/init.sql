INSERT INTO `testfilter`.`vocation` (`id`, `name`) VALUES ('1', 'engineer');
INSERT INTO `testfilter`.`vocation` (`id`, `name`) VALUES ('2', 'manager');

INSERT INTO `testfilter`.`department` (`id`, `name`) VALUES ('1', 'Sales');
INSERT INTO `testfilter`.`department` (`id`, `name`) VALUES ('2', 'Constructions');

INSERT INTO `testfilter`.`employee` (`id`, `age`, `name`, `salary`, `department_id`, `vocation_id`) VALUES ('1', '20', 'Nick', '4000', '1', '1');
INSERT INTO `testfilter`.`employee` (`id`, `age`, `name`, `salary`, `department_id`, `vocation_id`) VALUES ('2', '25', 'Mike', '5000', '2', '2');
INSERT INTO `testfilter`.`employee` (`id`, `age`, `name`, `salary`, `department_id`, `vocation_id`) VALUES ('3', '30', 'Ann', '6000', '1', '1');
INSERT INTO `testfilter`.`employee` (`id`, `age`, `name`, `salary`, `department_id`, `vocation_id`) VALUES ('4', '40', 'Jhon', '7000', '2', '2');
INSERT INTO `testfilter`.`employee` (`id`, `age`, `name`, `salary`, `department_id`, `vocation_id`) VALUES ('5', '18', 'Jane', '3000', '1', '2');
INSERT INTO `testfilter`.`employee` (`id`, `age`, `name`, `salary`, `department_id`, `vocation_id`) VALUES ('6', '21', 'Sam', '3500', '2', '1');
