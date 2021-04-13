begin transaction;

update open_hours
set open = 'Hours vary'
where open = 'Hours vary depending on local events, store hours, and restaurant hours.'
OR open = 'Hours vary depending on local events, store hours, and restaurant hours';

update open_hours
set close = 'Check website'
where close = 'Hours vary depending on local events, store hours, and restaurant hours.'
OR close = 'Hours vary depending on local events, store hours, and restaurant hours';

update destinations
set image = 'https://ssl.cdn-redfin.com/photo/159/bigphoto/534/4112534_12_1.jpg'
where name = 'Historic Little Italy in Cleveland';

update destinations
set image = 'https://files.slack.com/files-pri/T0GNFLF6D-F01U045LMFG/image.png'
where name = 'The Mall';

update destinations
set image = 'https://files.slack.com/files-pri/T0GNFLF6D-F01U73LPLQ3/image.png'
where name = 'JACK Cleveland Casino';

update destinations
set image = 'https://slack-imgs.com/?c=1&o1=ro&url=https%3A%2F%2Fs.wsj.net%2Fpublic%2Fresources%2Fimages%2FBN-TX747_JAPANR_M_20170619105228.jpg'
where name = 'Rock & Roll Hall of Fame';

update destinations
set image = 'https://slack-imgs.com/?c=1&o1=ro&url=https%3A%2F%2Fsosassociates.com%2Fsites%2Fdefault%2Ffiles%2FCleveland-Metroparks-Zoo.jpg'
where name = 'Cleveland Metroparks Zoo';

commit;
