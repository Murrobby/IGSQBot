CREATE TABLE IF NOT EXISTS reports
(
    reportId BIGSERIAL NOT NULL PRIMARY KEY,
    messageId BIGINT NOT NULL UNIQUE,
    reportMessageId BIGINT NOT NULL UNIQUE,
    channelId BIGINT NOT NULL UNIQUE,
    guildId BIGINT NOT NULL REFERENCES guilds(guildId) ON DELETE CASCADE,
    userId BIGINT NOT NULL,
    timeStamp TIMESTAMP NOT NULL DEFAULT current_timestamp,
    reportText TEXT NOT NULL
);