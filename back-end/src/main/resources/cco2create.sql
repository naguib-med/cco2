CREATE TABLE Users
(
    uid      BIGINT PRIMARY KEY,
    username VARCHAR UNIQUE,
    password BYTEA
);
CREATE TABLE Farm
(
    fid    BIGINT PRIMARY KEY,
    name   VARCHAR,
    uid_FK BIGINT REFERENCES Users (uid) ON DELETE CASCADE
);
CREATE TABLE Miner
(
    mid                                BIGINT PRIMARY KEY,
    gpu                                VARCHAR,
    manufacter                         VARCHAR,
    model                              VARCHAR,
    core_clock                         INT,
    mem_clock                          INT,
    operating_system                   VARCHAR,
    driver_version                     VARCHAR,
    mining_software                    VARCHAR,
    power_consumption                  INT,
    currency                           VARCHAR,
    algorythm                          VARCHAR,
    speed                              BIGINT,
    revenue_day                        REAL,
    revenue_month                      REAL,
    hashrate_watt                      REAL,
    revenue_month_electricity_deducted REAL
);
CREATE TABLE FHasM
(
    fid_FK BIGINT REFERENCES Farm (fid) ON DELETE CASCADE,
    mid_FK BIGINT REFERENCES Miner (mid) ON DELETE CASCADE,
    PRIMARY KEY (fid_FK, mid_FK)
);
CREATE SEQUENCE hibernate_sequence START 533;
