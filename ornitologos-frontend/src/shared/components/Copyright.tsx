import { Typography } from '@mui/material';

export function Copyright() {
  return (
    <Typography
      variant='body2'
      color='text.secondary'
      align='center'
      marginTop={7}
    >
      {'Copyright © '}
      Ornitologos amadores,
      {' ' + new Date().getFullYear()}
      {'.'}
    </Typography>
  );
}
